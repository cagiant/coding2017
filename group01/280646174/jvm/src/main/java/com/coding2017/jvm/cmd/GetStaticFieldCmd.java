package com.coding2017.jvm.cmd;

import com.coding2017.jvm.clz.ClassFile;
import com.coding2017.jvm.constant.ConstantPool;

public class GetStaticFieldCmd extends TwoOperandCmd {

    public GetStaticFieldCmd(ClassFile clzFile, String opCode) {
        super(clzFile, opCode);

    }

    @Override
    public String toString(ConstantPool pool) {

        return super.getOperandAsField(pool);
    }

}
