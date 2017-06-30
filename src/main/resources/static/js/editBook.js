/**
 * Created by andrusha on 20.06.17.
 */
getBookInfo();


function getBookInfo() {
    var bookId = location.search.substring(1);
    var idAndInt = bookId.split('=');
    bookId = idAndInt[1];
    $.ajax({
            url: '/books/' + bookId,
            success: function (data) {
                document.getElementById('author_id').setAttribute('value', data.author_id);
                document.getElementById('genre_id').setAttribute('value', data.genre_id);
                document.getElementById('publisher_id').setAttribute('value', data.publisher_id);
                document.getElementById('name').setAttribute('value', data.name);
                document.getElementById('pageCount').setAttribute('value', data.pageCount);
                document.getElementById('isbn').setAttribute('value', data.isbn);
                document.getElementById('publish_year').setAttribute('value', data.publisher_id);
            }
        }
    )
    ;
}

function edit() {
    var id = location.search.substring(1);
    var idAndInt = id.split('=');
    id = idAndInt[1];
    var author_id  = document.getElementById('author_id').value;
    var genre_id  = document.getElementById('genre_id').value;
    var publisher_id  = document.getElementById('publisher_id').value;
    var name  = document.getElementById('name').value;
    var pageCount  = document.getElementById('pageCount').value;
    var isbn  = document.getElementById('isbn').value;
    var publish_year = document.getElementById('publish_year').value;
    var Book = {id : id, author_id: author_id, genre_id: genre_id, publisher_id: publisher_id, name: name, pageCount: pageCount, isbn: isbn, publish_year:publish_year};
    $.ajax({
        url : "/books",
        contentType : 'application/json',
        data : JSON.stringify(Book),
        type : 'POST',
        success: function(data) {
            alert('Survey added: \n'+data);
        },
        error:  function(xhr, str){
        }
    });
    window.location.replace("/main");
}
