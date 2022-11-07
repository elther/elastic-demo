package com.example.elasticdemo.resource;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.example.elasticdemo.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SearchQueryBuilder {

    private final ElasticsearchClient client;

    public List<User> getByName(String text) throws IOException{
        List<Query> filterQueries = new ArrayList<>();
        var list = new ArrayList<User>();
        SearchResponse<User> search = client.search(s -> s
                .index("users")
                .query(q -> q
                        .term(t -> t
                                .field("name")
                                .value(v -> v.stringValue(text))))
                .query(q -> q.bool(b -> b.)), User.class);

        for(Hit<User> hit: search.hits().hits()){
            list.add(hit.source());
        }

        return list;
    }
}
