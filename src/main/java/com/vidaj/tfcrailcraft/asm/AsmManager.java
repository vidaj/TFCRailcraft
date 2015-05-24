package com.vidaj.tfcrailcraft.asm;

import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper;
import net.minecraft.launchwrapper.IClassTransformer;

public class AsmManager implements IClassTransformer {

	private final FMLDeobfuscatingRemapper mapper = FMLDeobfuscatingRemapper.INSTANCE;
	private final List<IClassProcessor> processors = new ArrayList<IClassProcessor>();

	public AsmManager() {
	}
	
	@Override
	public byte[] transform(String name, String transformedName,
			byte[] basicClass) {
		
		String deobfuscatedName = mapper.mapType(name).replace('/', '.');
		
		for (IClassProcessor processor : processors) {
			if (processor.accepts(deobfuscatedName)) {
				return processor.process(basicClass, name);
			}
		}
		
		return basicClass;
	}

}
