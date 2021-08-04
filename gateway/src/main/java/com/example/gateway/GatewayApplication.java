package com.example.gateway;

import org.reflections.Reflections;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.support.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AssignableTypeFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.nativex.hint.AccessBits;
import org.springframework.nativex.hint.TypeHint;

import java.lang.reflect.ParameterizedType;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@TypeHint(
	access = AccessBits.ALL,
	typeNames = {
		"org.springframework.cloud.gateway.filter.factory.AbstractNameValueGatewayFilterFactory$NameValueConfig",
		//
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
)
@SpringBootApplication
public class GatewayApplication {


	// Configurable.class, "org/springframework/cloud/gateway"
	private static void discoverConfigurableSubclasses1(Class<?> needle, String haystack)
		throws Exception {

		Set<Class<?>> classesToRegister = new HashSet<>();

		ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
		provider.addIncludeFilter(new AssignableTypeFilter(needle));
		Set<BeanDefinition> components = provider.findCandidateComponents(haystack);
		for (BeanDefinition component : components) {
			var beanClassName = component.getBeanClassName();
//			System.out.println("bean class name: " + beanClassName);
			var cls = Class.forName(beanClassName);
			classesToRegister.add(cls);
//			System.out.println("class name: " + cls.getName());
			try {
				var genericType = (Class<?>)
					((ParameterizedType) cls.getGenericSuperclass())
						.getActualTypeArguments()[0];
				classesToRegister.add(genericType);
//				System.out.println("generic type: " + genericType);
			}
			catch (Exception e) {
				System.err.println("couldn't get generic parameter for " + cls.getName());
			}
		}

		var hints = classesToRegister
			.stream()
			.filter(clazz -> !clazz.getName().contains("java.lang.Object"))
			.map(clzz -> '"' + clzz.getName() + '"')
			.collect(Collectors.joining(", " + System.lineSeparator()));

		System.out.println("hints: " + hints);

	}


	///

	private static  <C>  void discoverConfigurableSubclasses (Class<C> needle, String haystack)
		throws Exception {
		Reflections reflections = new Reflections(haystack .replaceAll("/", "."));
		Set<Class<? extends C >> subTypes = reflections.getSubTypesOf(needle);
		for(var clazz: subTypes) {
			System.out.println(clazz.getName());
		}

	}

	public static void main(String[] args) throws Exception {
		discoverConfigurableSubclasses(Configurable.class, "org/springframework/cloud/gateway");
		//SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	RouteLocator gateway(RouteLocatorBuilder rlb) {
		return rlb
			.routes()
			.route(rs -> rs
				.path("/proxy")
				.filters(fs -> fs
					.setPath("/")
					.addResponseHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*")
				)
				.uri("https://start.spring.io/")
			)
			.build();
	}
}

