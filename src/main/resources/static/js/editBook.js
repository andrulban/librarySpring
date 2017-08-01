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
                document.getElementById('id').setAttribute('value', data.id);
                document.getElementById('author').setAttribute('value', data.author.fio);
                document.getElementById('genre').setAttribute('value', data.genre.nameG);
                document.getElementById('publisher').setAttribute('value', data.publisher.nameP);
                document.getElementById('name').setAttribute('value', data.name);
                document.getElementById('pageCount').setAttribute('value', data.pageCount);
                document.getElementById('isbn').setAttribute('value', data.isbn);
                document.getElementById('publishYear').setAttribute('value', data.publishYear);

                document.getElementById('image').setAttribute('value', data.image);
                document.getElementById('content').setAttribute('value', data.content);
            }
        }
    )
    ;
}

function edit() {

    var id  = document.getElementById('id').value;
    var author_id  = document.getElementById('author_id').value;
    var genre_id  = document.getElementById('genre_id').value;
    var publisher_id  = document.getElementById('publisher_id').value;
    var name  = document.getElementById('name').value;
    var pageCount  = document.getElementById('pageCount').value;
    var isbn  = document.getElementById('isbn').value;
    var publishYear = document.getElementById('publishYear').value;
    var Book = {id : id, author_id: author_id, genre_id: genre_id, publisher_id: publisher_id, name: name, pageCount: pageCount, isbn: isbn, publishYear: publishYear};
    $.ajax({
        url : "/booksEdit",
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



// function getBookInfo() {
//     var bookId = location.search.substring(1);
//     var idAndInt = bookId.split('=');
//     bookId = idAndInt[1];
//     $.ajax({
//             url: '/fullBooks/' + bookId,
//             success: function (data) {
//                 alert(data.name);
//                 alert(data.image);
//                 $.ajax({
//                     url: "/booksEdit",
//                     contentType : 'application/json',
//                     data : JSON.stringify(data),
//                     type : 'POST',
//                     success: function(data) {
//                         alert(data.name);
//                         alert(data.image);
//                     },
//                     error:  function(xhr, str){
//                         alert('Error');
//                     }
//                 });
//
//             }
//         }
//     )
//     ;
// }