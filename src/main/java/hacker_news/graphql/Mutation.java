package hacker_news.graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import hacker_news.graphql.model.Link;
import hacker_news.graphql.repository.LinkRepository;

public class Mutation implements GraphQLRootResolver {
    
    private final LinkRepository linkRepository;

    public Mutation(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }
    
    public Link createLink(String url, String description) {
        Link newLink = new Link(url, description);
        linkRepository.saveLink(newLink);
        return newLink;
    }
}