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


/*
@TypeHint(
	access = AccessBits.ALL,
	typeNames = {
		"org.springframework.cloud.gateway.filter.factory.AbstractNameValueGatewayFilterFactory$NameValueConfig",
		"org.springframework.cloud.gateway.handler.predicate.ReadBodyRoutePredicateFactory",
		"org.springframework.cloud.gateway.handler.predicate.QueryRoutePredicateFactory",
		"org.springframework.cloud.gateway.filter.factory.RequestRateLimiterGatewayFilterFactory$Config",
		"org.springframework.cloud.gateway.filter.factory.PrefixPathGatewayFilterFactory",
		"org.springframework.cloud.gateway.filter.factory.PreserveHostHeaderGatewayFilterFactory",
		"org.springframework.cloud.gateway.filter.factory.SecureHeadersGatewayFilterFactory$Config",
		"org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory$NameConfig",
		"org.springframework.cloud.gateway.filter.factory.SetStatusGatewayFilterFactory",
		"org.springframework.cloud.gateway.handler.predicate.PathRoutePredicateFactory$Config",
		"org.springframework.cloud.gateway.filter.factory.AddRequestHeaderGatewayFilterFactory",
		"org.springframework.cloud.gateway.filter.factory.rewrite.ModifyResponseBodyGatewayFilterFactory",
		"org.springframework.cloud.gateway.filter.factory.RequestRateLimiterGatewayFilterFactory",
		"org.springframework.cloud.gateway.filter.factory.RemoveRequestParameterGatewayFilterFactory",
		"org.springframework.cloud.gateway.filter.factory.SetRequestHostHeaderGatewayFilterFactory",
		"org.springframework.cloud.gateway.filter.factory.FallbackHeadersGatewayFilterFactory$Config",
		"org.springframework.cloud.gateway.handler.predicate.HeaderRoutePredicateFactory",
		"org.springframework.cloud.gateway.handler.predicate.HostRoutePredicateFactory",
		"org.springframework.cloud.gateway.filter.factory.RequestHeaderToRequestUriGatewayFilterFactory",
		"org.springframework.cloud.gateway.filter.factory.MapRequestHeaderGatewayFilterFactory$Config",
		"org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter",
		"org.springframework.cloud.gateway.filter.factory.RewriteLocationResponseHeaderGatewayFilterFactory",
		"org.springframework.cloud.gateway.filter.factory.StripPrefixGatewayFilterFactory",
		"org.springframework.cloud.gateway.filter.factory.rewrite.ModifyResponseBodyGatewayFilterFactory$Config",
		"org.springframework.cloud.gateway.filter.factory.RequestHeaderSizeGatewayFilterFactory",
		"org.springframework.cloud.gateway.filter.factory.RedirectToGatewayFilterFactory$Config",
		"org.springframework.cloud.gateway.support.WeightConfig",
		"org.springframework.cloud.gateway.handler.predicate.CookieRoutePredicateFactory$Config",
		"org.springframework.cloud.gateway.filter.factory.StripPrefixGatewayFilterFactory$Config",
		"org.springframework.cloud.gateway.handler.predicate.RemoteAddrRoutePredicateFactory",
		"org.springframework.cloud.gateway.filter.factory.DedupeResponseHeaderGatewayFilterFactory$Config",
		"org.springframework.cloud.gateway.handler.predicate.AfterRoutePredicateFactory",
		"org.springframework.cloud.gateway.handler.predicate.CookieRoutePredicateFactory",
		"org.springframework.cloud.gateway.config.conditional.OnEnabledPredicate$DefaultValue",
		"org.springframework.cloud.gateway.filter.factory.AddRequestParameterGatewayFilterFactory",
		"org.springframework.cloud.gateway.handler.predicate.BetweenRoutePredicateFactory",
		"org.springframework.cloud.gateway.filter.factory.PrefixPathGatewayFilterFactory$Config",
		"org.springframework.cloud.gateway.filter.factory.SecureHeadersGatewayFilterFactory",
		"org.springframework.cloud.gateway.filter.factory.DedupeResponseHeaderGatewayFilterFactory",
		"org.springframework.cloud.gateway.filter.factory.RemoveResponseHeaderGatewayFilterFactory",
		"org.springframework.cloud.gateway.filter.factory.rewrite.ModifyRequestBodyGatewayFilterFactory$Config",
		"org.springframework.cloud.gateway.filter.factory.SetPathGatewayFilterFactory",
		"org.springframework.cloud.gateway.filter.factory.RequestHeaderSizeGatewayFilterFactory$Config",
		"org.springframework.cloud.gateway.handler.predicate.BetweenRoutePredicateFactory$Config",
		"org.springframework.cloud.gateway.handler.predicate.BeforeRoutePredicateFactory$Config",
		"org.springframework.cloud.gateway.handler.predicate.BeforeRoutePredicateFactory",
		"org.springframework.cloud.gateway.handler.predicate.MethodRoutePredicateFactory$Config",
		"org.springframework.cloud.gateway.handler.predicate.ReadBodyRoutePredicateFactory$Config",
		"org.springframework.cloud.gateway.handler.predicate.WeightRoutePredicateFactory",
		"org.springframework.cloud.gateway.handler.predicate.RemoteAddrRoutePredicateFactory$Config",
		"org.springframework.cloud.gateway.filter.factory.TokenRelayGatewayFilterFactory",
		"org.springframework.cloud.gateway.filter.factory.FallbackHeadersGatewayFilterFactory",
		"org.springframework.cloud.gateway.filter.factory.SetResponseHeaderGatewayFilterFactory",
		"org.springframework.cloud.gateway.handler.predicate.PathRoutePredicateFactory",
		"org.springframework.cloud.gateway.handler.predicate.MethodRoutePredicateFactory",
		"org.springframework.cloud.gateway.config.conditional.OnEnabledFilter$DefaultValue",
		"org.springframework.cloud.gateway.filter.factory.rewrite.ModifyRequestBodyGatewayFilterFactory",
		"org.springframework.cloud.gateway.filter.factory.RequestSizeGatewayFilterFactory",
		"org.springframework.cloud.gateway.filter.factory.RewriteResponseHeaderGatewayFilterFactory$Config",
		"org.springframework.cloud.gateway.handler.predicate.QueryRoutePredicateFactory$Config",
		"org.springframework.cloud.gateway.filter.factory.RewritePathGatewayFilterFactory",
		"org.springframework.cloud.gateway.filter.factory.AddResponseHeaderGatewayFilterFactory",
		"org.springframework.cloud.gateway.handler.predicate.AfterRoutePredicateFactory$Config",
		"org.springframework.cloud.gateway.filter.factory.SetStatusGatewayFilterFactory$Config",
		"org.springframework.cloud.gateway.filter.factory.SpringCloudCircuitBreakerResilience4JFilterFactory",
		"org.springframework.cloud.gateway.filter.factory.RewritePathGatewayFilterFactory$Config",
		"org.springframework.cloud.gateway.filter.factory.RequestSizeGatewayFilterFactory$RequestSizeConfig",
		"org.springframework.cloud.gateway.filter.factory.SetPathGatewayFilterFactory$Config",
		"org.springframework.cloud.gateway.filter.factory.SaveSessionGatewayFilterFactory",
		"org.springframework.cloud.gateway.handler.predicate.CloudFoundryRouteServiceRoutePredicateFactory",
		"org.springframework.cloud.gateway.filter.factory.RetryGatewayFilterFactory",
		"org.springframework.cloud.gateway.filter.factory.RewriteLocationResponseHeaderGatewayFilterFactory$Config",
		"org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter$Config",
		"org.springframework.cloud.gateway.filter.factory.MapRequestHeaderGatewayFilterFactory",
		"org.springframework.cloud.gateway.filter.factory.SetRequestHeaderGatewayFilterFactory",
		"org.springframework.cloud.gateway.handler.predicate.HeaderRoutePredicateFactory$Config",
		"org.springframework.cloud.gateway.filter.factory.RemoveRequestHeaderGatewayFilterFactory",
		"org.springframework.cloud.gateway.filter.factory.SetRequestHostHeaderGatewayFilterFactory$Config",
		"org.springframework.cloud.gateway.filter.factory.RetryGatewayFilterFactory$RetryConfig",
		"org.springframework.cloud.gateway.filter.factory.RewriteResponseHeaderGatewayFilterFactory",
		"org.springframework.cloud.gateway.filter.factory.RedirectToGatewayFilterFactory",
		"org.springframework.cloud.gateway.handler.predicate.HostRoutePredicateFactory$Config"
	}
) */
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
