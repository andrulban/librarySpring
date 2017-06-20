/**
 * Created by andrusha on 20.06.17.
 */
function create() {
    var author_id = document.getElementById('author_id').value;
    var genre_id = document.getElementById('genre_id').value;
    var publisher_id = document.getElementById('publisher_id').value;
    var name = document.getElementById('name').value;
    var pageCount = document.getElementById('pageCount').value;
    var isbn = document.getElementById('isbn').value;
    var publish_year = document.getElementById('publish_year').value;
    var Book = {
        id: 0,
        author_id: author_id,
        genre_id: genre_id,
        publisher_id: publisher_id,
        name: name,
        pageCount: pageCount,
        isbn: isbn,
        publish_year: publish_year
    };
    $.ajax({
        url: "/doAddBook",
        contentType: 'application/json',
        data: JSON.stringify(Book),
        type: 'POST',
        success: function (data) {
            alert('Survey added: \n' + data);
        }
    });
    window.location.replace("/books");
}