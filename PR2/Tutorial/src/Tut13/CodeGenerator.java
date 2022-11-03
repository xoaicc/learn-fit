package Tut13;

import Tut13.design.MobilePhone;

import java.lang.reflect.Field;

public class CodeGenerator {
    private final Class<?> cls;

    public CodeGenerator(Class<?> cls) {
        this.cls = cls;
    }

    public String generateGetter(String attr) throws NoSuchFieldException {
        Field f = cls.getDeclaredField(attr);
        String type = f.getType().getSimpleName();
        return type;
    }

    public void printSrc() throws NoSuchFieldException {

    }

    public static void main(String[] args) throws NoSuchFieldException {
        CodeGenerator cg = new CodeGenerator(MobilePhone.class);
        String src = cg.generateGetter("manName");
        System.out.println(src);
    }

}
