package hacker_news.graphql;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import hacker_news.graphql.model.Link;
import hacker_news.graphql.repository.LinkRepository;

public class Query implements GraphQLRootResolver {
    
    private final LinkRepository linkRepository;

    public Query(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public List<Link> allLinks() {
        return linkRepository.getAllLinks();
    }
}