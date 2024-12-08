package in.shaukat.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Set;

@Component
public class MyFilter implements GlobalFilter {


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        System.out.println("Filter Executed...!");

        ServerHttpRequest request = exchange.getRequest();
        HttpHeaders headers = request.getHeaders();
        Set<String> keySet = headers.keySet();

        if(!keySet.contains("secret")){
            throw new RuntimeException("Invalid Request");
        }

        List<String> list = headers.get("secret");
        if(!list.get(0).equals("shaukat@123")){
            throw new RuntimeException("Invalid Request");
        }

        return chain.filter(exchange);
    }
}
