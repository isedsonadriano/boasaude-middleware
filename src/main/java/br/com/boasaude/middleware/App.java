package br.com.boasaude.middleware;

import javax.ws.rs.core.MediaType;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.boot.autoconfigure.security.oauth2.resource.servlet.OAuth2ResourceServerAutoConfiguration;
import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration;
import org.springframework.boot.autoconfigure.websocket.servlet.WebSocketServletAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import br.com.boasaude.middleware.dto.AssociadosDTO;
import br.com.boasaude.middleware.dto.ConveniadosDTO;
import br.com.boasaude.middleware.dto.PrestadoresDTO;
import br.com.boasaude.middleware.integration.IntegrationSafMock;
import br.com.boasaude.middleware.integration.IntegrationSasMock;
import br.com.boasaude.middleware.integration.IntegrationSgpsMock;

@SpringBootApplication(exclude = { WebSocketServletAutoConfiguration.class, AopAutoConfiguration.class, OAuth2ResourceServerAutoConfiguration.class, EmbeddedWebServerFactoryCustomizerAutoConfiguration.class })
@ComponentScan(basePackages = "br.com.boasaude.middleware")
public class App {
	
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Component
    class RestApi extends RouteBuilder {
    	
    	@Autowired
    	private IntegrationSgpsMock integrationSgpsMock;

        @Override
        public void configure() {
            criarRotaAssociado();
            criarRotaConveniado();
            criarRotaPrestadore();
        }

		private void criarRotaAssociado() {
			rest("/api/saf").description("Integra????o com SAF")
				.id("api-route")
                .get("/associados")
                .produces(MediaType.APPLICATION_JSON)
                .consumes(MediaType.APPLICATION_JSON)
                .bindingMode(RestBindingMode.auto)
                .type(AssociadosDTO.class)
                .enableCORS(true)
                .to("direct:safService");

            from("direct:safService").routeId("direct-route-saf")
                .tracing()
                .process(new Processor() {
                    @Override
							public void process(Exchange exchange) throws Exception {
								AssociadosDTO associados = new IntegrationSafMock().execute();
								exchange.getIn().setBody(associados);
							}
                })
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(201));
		}

		private void criarRotaConveniado() {
			rest("/api/sas").description("Integra????o com SAS")
            .id("api-route")
            .get("/conveniados")
            .produces(MediaType.APPLICATION_JSON)
            .consumes(MediaType.APPLICATION_JSON)
            .bindingMode(RestBindingMode.auto)
            .type(ConveniadosDTO.class)
            .enableCORS(true)
            .to("direct:sasService");

        from("direct:sasService").routeId("direct-route-sas")
            .tracing()
            .process(new Processor() {
                @Override
						public void process(Exchange exchange) throws Exception {
							ConveniadosDTO conveniados = new IntegrationSasMock().execute();
							exchange.getIn().setBody(conveniados);
						}
            })
            .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(201));			
		}
		
		private void criarRotaPrestadore() {
			rest("/api/sgps/").description("Integra????o com SGPS")
            .id("api-route")
            .get("/prestadores")
            .produces(MediaType.APPLICATION_JSON)
            .consumes(MediaType.APPLICATION_JSON)
            .bindingMode(RestBindingMode.auto)
            .type(AssociadosDTO.class)
            .enableCORS(true)
            .to("direct:sgpsService");

        from("direct:sgpsService").routeId("direct-route-sgps")
            .tracing()
            .process(new Processor() {
                @Override
							public void process(Exchange exchange) throws Exception {
								PrestadoresDTO prestadores = integrationSgpsMock.execute();
								exchange.getIn().setBody(prestadores);
							}
            })
            .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(201));
        
		}
		
    }
}
