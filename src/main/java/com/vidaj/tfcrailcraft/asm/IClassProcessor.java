package com.vidaj.tfcrailcraft.asm;

public interface IClassProcessor {

	public boolean accepts(String name);
	
	public byte[] process(byte[] basicClass, String name);
}
