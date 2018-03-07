package hacker_news.graphql;

import javax.servlet.annotation.WebServlet;

import com.coxautodev.graphql.tools.SchemaParser;

import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
import hacker_news.graphql.repository.LinkRepository;

@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndpoint extends SimpleGraphQLServlet {

	private static final long serialVersionUID = 2436373534272074697L;

	public GraphQLEndpoint() {
        super(buildSchema());
    }

    private static GraphQLSchema buildSchema() {
    	LinkRepository linkRepository = new LinkRepository();
        return SchemaParser.newParser()
                .file("schema.graphqls")
                .resolvers(
                		new Query(linkRepository), 
                		new Mutation(linkRepository))
                .build()
                .makeExecutableSchema();
    }
}