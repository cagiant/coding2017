package com.coding2017.jvm.print;

import com.coding2017.jvm.clz.ClassFile;
import com.coding2017.jvm.loader.ClassFileLoader;

public class ClassFilePrinter {
    ClassFile clzFile = null;

    public ClassFilePrinter(ClassFile clzFile) {
        this.clzFile = clzFile;
    }

    public void print() {

        if (clzFile.getAccessFlag().isPublicClass()) {
            System.out.println("Access flag : public  ");
        }
        System.out.println("Class Name:" + clzFile.getClassName());

        System.out.println("Super Class Name:" + clzFile.getSuperClassName());

        System.out.println("minor version:" + clzFile.getMinorVersion());

        System.out.println("major version:" + clzFile.getMinorVersion());

        ConstantPoolPrinter cnstPoolPrinter = new ConstantPoolPrinter(clzFile.getConstantPool());
        cnstPoolPrinter.print();

    }

    public static void main(String[] args) {
        String path1 = "/Users/kaitao.li/code/study/coding2017/group01/280646174/jvm/target/classes";
        ClassFileLoader loader = new ClassFileLoader();
        loader.addClassPath(path1);
        String className = "EmployeeV1";

        ClassFile clzFile = loader.loadClass(className);

        ClassFilePrinter printer = new ClassFilePrinter(clzFile);

        printer.print();
    }
}
