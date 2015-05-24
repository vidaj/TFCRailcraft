package com.vidaj.tfcrailcraft.asm;

import java.util.Set;

import org.objectweb.asm.*;

public abstract class ClassProcessorBase implements IClassProcessor {

	protected abstract Set<String> getClassNamesToProcess();
	
	protected abstract ClassVisitor createClassVisitor(ClassWriter writer);
	
	protected void appendExtraMethods(ClassWriter writer) { }

	@Override
	public boolean accepts(String name) {
		for (String toMatch : getClassNamesToProcess()) {
			if (toMatch.equals(name)) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public byte[] process(byte[] basicClass, String name) {
		ClassReader cr = new ClassReader(basicClass);
		ClassWriter cw = new ClassWriter(cr, 0);
		ClassVisitor ca = createClassVisitor(cw);
		cr.accept(ca, 0);
		
		appendExtraMethods(cw);
		
		byte[] b2 = cw.toByteArray();
		return b2;
	}
	
	
}
