// /**
//  * Created by andrusha on 20.06.17.
//  */
// function create() {
//
//     function arrayBufferToBase64(arrayBuffer) {
//         var bytes = new Uint8Array(arrayBuffer);
//         var len = bytes.byteLength;
//         var binary = '';
//         for (var i = 0; i < len; i++) {
//             binary += String.fromCharCode(bytes[i]);
//         }
//         return window.btoa(binary);
//     }
//
//     var author = document.getElementById('author').value;
//     var genre = document.getElementById('genre').value;
//     var publisher = document.getElementById('publisher').value;
//     var name = document.getElementById('name').value;
//     var pageCount = document.getElementById('pageCount').value;
//     var isbn = document.getElementById('isbn').value;
//     var publishYear = document.getElementById('publishYear').value;
//
//     var image = {};
//     var content = {};
//
//     var file = $('input[type="file"]').get(0).files[0];
//     if (file) {
//
//         var reader = new FileReader();
//
//         // after the file has loaded on the client,
//         // convert to base64 and assign to the item before POSTing
//         reader.onload = function loaded(evt) {
//             image.bytes = arrayBufferToBase64(evt.target.result);
//             image.contentType = file.type;
//             alert(image.bytes);
//
//             var Book = {
//                 id: 0,
//                 author: author,
//                 genre: genre,
//                 publisher: publisher,
//                 name: name,
//                 pageCount: pageCount,
//                 isbn: isbn,
//                 publishYear: publishYear,
//                 image: image,
//                 content: content
//             };
//             $.ajax({
//                 url: "/books",
//                 contentType: 'application/json',
//                 data: JSON.stringify(Book),
//                 type: 'PUT',
//                 success: function (data) {
//                     alert('Survey added: \n' + data);
//                 }
//             });
//             window.location.replace("/main");
//         };
//
//         // post json object as the request body
//         // with the technique of your choice
//         // I like using $.ajax(...)
//     }
//     ;
//
//     reader.readAsArrayBuffer(file);
// }
