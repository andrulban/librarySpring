/**
 * Created by andrusha on 20.06.17.
 */
function create() {

    function arrayBufferToBase64(arrayBuffer) {
        var bytes = new Uint8Array(arrayBuffer);
        var len = bytes.byteLength;
        var binary = '';
        for (var i = 0; i < len; i++) {
            binary += String.fromCharCode(bytes[i]);
        }
        return window.btoa(binary);
    }

    var author_id = document.getElementById('author_id').value;
    var genre_id = document.getElementById('genre_id').value;
    var publisher_id = document.getElementById('publisher_id').value;
    var name = document.getElementById('name').value;
    var pageCount = document.getElementById('pageCount').value;
    var isbn = document.getElementById('isbn').value;
    var publish_year = document.getElementById('publish_year').value;

    var image = {};
    var content = {};

    var file = $('input[type="file"]').get(0).files[0];
    if (file) {

        var reader = new FileReader();

        // after the file has loaded on the client,
        // convert to base64 and assign to the item before POSTing
        reader.onload = function loaded(evt) {
            image.bytes = arrayBufferToBase64(evt.target.result);
            image.contentType = file.type;
            alert(image.bytes);

            var Book = {
                id: 0,
                author_id: author_id,
                genre_id: genre_id,
                publisher_id: publisher_id,
                name: name,
                pageCount: pageCount,
                isbn: isbn,
                publish_year: publish_year,
                image: image,
                content: content
            };
            $.ajax({
                url: "/books",
                contentType: 'application/json',
                data: JSON.stringify(Book),
                type: 'PUT',
                success: function (data) {
                    alert('Survey added: \n' + data);
                }
            });
            window.location.replace("/main");
        };

        // post json object as the request body
        // with the technique of your choice
        // I like using $.ajax(...)
    }
    ;

    reader.readAsArrayBuffer(file);
}
