package gateway;

import org.springframework.cloud.gateway.config.GatewayAutoConfiguration;
import org.springframework.cloud.gateway.support.Configurable;
import org.springframework.nativex.hint.AccessBits;
import org.springframework.nativex.hint.NativeHint;
import org.springframework.nativex.type.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@NativeHint(trigger = GatewayAutoConfiguration.class)
public class GatewayHints implements NativeConfiguration {

	@Override
	public boolean isValid(TypeSystem typeSystem) {
		return typeSystem.resolve(Configurable.class) != null;
	}


	private static Set<Type> getSubtypesFor(Type type, TypeSystem typeSystem) {
		var nameOfType = type.isInterface() ? type.getName() : type.getDescriptor();
		return typeSystem
			.scanUserCodeDirectoriesAndSpringJars((t) -> {
				try {
					return !t.equals(type) && (
						type.isInterface() ?
							t.implementsInterface(nameOfType) :
							t.extendsClass(nameOfType)
					);
				}
				catch (Throwable error) {
					log(error.getMessage());
					return false;
				}
			})
			.map(t -> typeSystem.resolve(t.getName(), false))
			.collect(Collectors.toSet());
	}

	@Override
	public List<HintDeclaration> computeHints(TypeSystem typeSystem) {
		log("computing hints...");
		Type configurableResolve = typeSystem.resolve(Configurable.class);
		if (configurableResolve != null) {
			Set<String> export = new HashSet<>();
			Set<Type> subtypesFor = getSubtypesFor(configurableResolve, typeSystem);
			for (var type : subtypesFor) {
				export.add(type.getName());
				try {
					export.addAll(type.getTypesInSignature());
				}
				catch (Throwable t) {
					log("can't add signature types :" + t.getMessage());
				}
			}
			if (export.size() > 0) {
				return export
					.stream()
					.map( name -> name.replaceAll("/", "."))
					.map(GatewayHints::fromType)
					.collect(Collectors.toList());
			}
		}
		return NativeConfiguration
			.super.computeHints(typeSystem);
	}


	private static HintDeclaration fromType(String clazzName) {
		var hd = new HintDeclaration();
		hd.addDependantType(clazzName, new AccessDescriptor(AccessBits.ALL));
		log("building HintDeclaration for " + clazzName + '.');
		return hd;
	}

	private static void log(String m, String... msgs) {
		log(String.format(m, msgs));
	}

	private static void log(String msg) {
		System.out.println(msg);
	}
}
