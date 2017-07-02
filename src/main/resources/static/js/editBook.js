/**
 * Created by andrusha on 20.06.17.
 */
getBookInfo();


function getBookInfo() {
    var bookId = location.search.substring(1);
    var idAndInt = bookId.split('=');
    bookId = idAndInt[1];
    $.ajax({
            url: '/fullBooks/' + bookId,
            success: function (data) {
                var id = location.search.substring(1);
                var idAndInt = id.split('=');
                id = idAndInt[1];
                document.getElementById('id').setAttribute('value', id);
                document.getElementById('author_id').setAttribute('value', data.author_id);
                document.getElementById('genre_id').setAttribute('value', data.genre_id);
                document.getElementById('publisher_id').setAttribute('value', data.publisher_id);
                document.getElementById('name').setAttribute('value', data.name);
                document.getElementById('pageCount').setAttribute('value', data.pageCount);
                document.getElementById('isbn').setAttribute('value', data.isbn);
                document.getElementById('publishYear').setAttribute('value', data.publishYear);

                document.getElementById('image').setAttribute('value', data.image);
                alert(data.image);
                document.getElementById('content').setAttribute('value', data.content);
                alert(data.content);

            }
        }
    )
    ;
}

// function edit() {
//
//     var id  = document.getElementById('id').value;
//     var author_id  = document.getElementById('author_id').value;
//     var genre_id  = document.getElementById('genre_id').value;
//     var publisher_id  = document.getElementById('publisher_id').value;
//     var name  = document.getElementById('name').value;
//     var pageCount  = document.getElementById('pageCount').value;
//     var isbn  = document.getElementById('isbn').value;
//     var publishYear = document.getElementById('publishYear').value;
//     var Book = {id : id, author_id: author_id, genre_id: genre_id, publisher_id: publisher_id, name: name, pageCount: pageCount, isbn: isbn, publishYear: publishYear};
//     $.ajax({
//         url : "/books",
//         contentType : 'application/json',
//         data : JSON.stringify(Book),
//         type : 'POST',
//         success: function(data) {
//             alert('Survey added: \n'+data);
//         },
//         error:  function(xhr, str){
//         }
//     });
//     window.location.replace("/main");
// }
