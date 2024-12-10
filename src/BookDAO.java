import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDeleteExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookDAO {

    private DynamoDBMapper mapper;

    /**
     * Allows access to and manipulation of Book objects from the data store.
     * @param mapper Access to DynamoDB
     */
    public BookDAO(DynamoDBMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * Uses the query() method to retrieve all the items from the BooksRead table that have a given employee id value.
     * @param employeeId the employee ID
     * @return the PaginatedQueryList that is returned from the query
     */
    public List<Book> getBooksReadByEmployee(String employeeId) { //(Book book) {

        Book book = new Book();
        book.setId(employeeId);


        DynamoDBQueryExpression<Book> dynamoDBQueryExpression = new DynamoDBQueryExpression<Book>()
                .withHashKeyValues(book);

        PaginatedQueryList<Book> bookList = mapper.query(Book.class, dynamoDBQueryExpression);


        return bookList;
    }

}
