package com.xckj.palfishsp;


import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;

/**
 * PalfishSp注解处理类
 */
public class PalfishSpProcessor extends AbstractProcessor {

    public static final TypeName STRING = ClassName.get("java.lang", "String");

    String packageName = "com.xckj.palfishsp";
    private String className = "PalfishSPUtil";
    private String SpUtilClassPath = "com.test.sharedpreferencedemo.SPUtil.";

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
    }


    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> types = new LinkedHashSet<>();
        types.add(PalfishSp.class.getCanonicalName());
        return types;
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if (annotations != null && annotations.size() != 0) {
            Set<? extends Element> palfishElements = roundEnv.getElementsAnnotatedWith(PalfishSp.class);
            try {
                this.parsePalfishSp(palfishElements);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }

        return false;
    }

    private void parsePalfishSp(Set<? extends Element> roundEnvironment) {
        System.out.println("------ process -----");
        JavaFile build = null;
        List<MethodSpec> methods = new LinkedList<>();
        for (Element element : roundEnvironment) {
            if (ElementKind.FIELD.equals(element.getKind())) {
                VariableElement variableElement = (VariableElement) element;
                PalfishSp palfishSp = variableElement.getAnnotation(PalfishSp.class);
                String key = palfishSp.key();
                String name = palfishSp.name();

                TypeName fieldType = ClassName.get(variableElement.asType());
                String fieldName = variableElement.getSimpleName().toString();
                Object value = variableElement.getConstantValue();
                System.out.println("------ process -----" + "  fieldName =  " + fieldName
                        + "  key =" + key + "  fieldType =" + fieldType + "  name =" + name + "  value =" + value);

                String getMethodState = null;
                String setMethodState = null;
                Type returnClass = null;
                if (isBool(fieldType)) {
                    getMethodState = "getBoolean";
                    setMethodState = "putBoolean";
                    returnClass = boolean.class;
                } else if (isInt(fieldType)) {
                    getMethodState = "getInt";
                    setMethodState = "putInt";
                    returnClass = int.class;
                } else if (isLong(fieldType)) {
                    getMethodState = "getLong";
                    setMethodState = "putLong";
                    returnClass = long.class;
                } else if (isString(fieldType)) {
                    getMethodState = "getString";
                    setMethodState = "putString";
                    returnClass = String.class;
                }
                MethodSpec getMethod = MethodSpec.methodBuilder("get" + fieldName)
                        .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                        .returns(returnClass)
                        .addStatement("return " + SpUtilClassPath + getMethodState + "($S)", key)
                        .addJavadoc(name + "\n")
                        .build();
                MethodSpec getMethodWithDefValue = MethodSpec.methodBuilder("get" + fieldName)
                        .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                        .returns(returnClass)
                        .addParameter(returnClass, "defaultValue")
                        .addStatement("return " + SpUtilClassPath + getMethodState + "($S, defaultValue)", key)
                        .addJavadoc(name + "\n")
                        .build();
                MethodSpec setMethod = MethodSpec.methodBuilder("set" + fieldName)
                        .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                        .returns(void.class)
                        .addParameter(returnClass, "value")
                        .addStatement(SpUtilClassPath + setMethodState + "($S, value)", key)
                        .addJavadoc(name + "\n")
                        .build();
                methods.add(getMethod);
                methods.add(getMethodWithDefValue);
                methods.add(setMethod);
            }
        }
        TypeSpec type = TypeSpec.classBuilder(className)
                .addModifiers(Modifier.PUBLIC)
                .addMethods(methods)
                .build();
        build = JavaFile.builder(packageName, type)
                .build();
        try {
            build.writeTo(processingEnv.getFiler());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    boolean isBool(TypeName fieldType) {
        return fieldType.equals(ClassName.BOOLEAN);
    }

    boolean isString(TypeName fieldType) {
        return fieldType.equals(STRING);
    }

    boolean isInt(TypeName fieldType) {
        return fieldType.equals(ClassName.INT);
    }

    boolean isLong(TypeName fieldType) {
        return fieldType.equals(ClassName.LONG);
    }

}
