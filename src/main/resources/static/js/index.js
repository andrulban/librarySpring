/**
 * Created by andrusha on 20.06.17.
 */
showBooks('/books');
showAllGenres();

function deleteBook(id) {
    if (confirm('Do you really want to delete this book?')) {
        $.ajax({
            url: '/books/' + id,
            type: 'DELETE',
            success: function (data) {

            }
        });
    }
    showBooks('/books');
}

function searchBooksByName() {
    if (document.getElementById('searchText').value === '') {
        showBooks('/books');
    }
    showBooks('/books/name/' + document.getElementById('searchText').value);
}

function showAllGenres() {
    $.ajax({
        url: '/genres',
        success: function (data) {
            var rightContent = document.getElementById('genresDiv');

            var ulelem = document.createElement('ul');
            $.each(data, function (index, element) {
                var line = document.createElement('li');
                var genreHref = document.createElement('a');
                genreHref.innerHTML = element.genreName;


                genreHref.onclick = function () {
                    showBooks('/books/genreId/' + element.id);
                };

                line.appendChild(genreHref);
                ulelem.appendChild(line);
            });
            rightContent.appendChild(ulelem);
        }

    });

}

function showBooks(url) {
    $.ajax({
        url: url,
        success: function (data) {
            var parent = document.getElementById('booksDiv');

            while (parent.firstChild) {
                parent.removeChild(parent.firstChild);
            }

            var box_sh = document.createElement('div');
            box_sh.setAttribute('class', 'box-sh');

            var amountOfBooks = document.createElement('h1');
            amountOfBooks.innerHTML = data.length + ' books found';


            var addHref = document.createElement('a');
            addHref.innerHTML = 'Add';
            addHref.setAttribute('type', 'button');
            addHref.setAttribute('id', 'button');
            addHref.setAttribute('href', '/bookAdding')

            box_sh.appendChild(amountOfBooks);
            box_sh.appendChild(addHref);
            parent.appendChild(box_sh);


            $.each(data, function (index, element) {

                var child = document.createElement('div');
                child.setAttribute('class', 'item');
                child.setAttribute('id', 'child');

                var info = document.createElement('div');
                info.setAttribute('class', 'info');

                var clear = document.createElement('div');
                clear.setAttribute('class', 'clear');

                var img = document.createElement('img');
                img.setAttribute('width', '100');
                img.setAttribute('height', '147');
                img.setAttribute('src', '/image/' + element.id);

                var titleHref = document.createElement('a');
                titleHref.setAttribute('class', 'title');
                titleHref.setAttribute('href', '/content/read?id=' + element.id);
                titleHref.setAttribute('target', '_blank');

                var titleP = document.createElement('p');
                titleP.innerHTML = element.name;

                var readHref = document.createElement('a');
                readHref.setAttribute('class', 'mr');
                readHref.setAttribute('href', '/content/read?id=' + element.id);
                readHref.setAttribute('target', '_blank');

                var downloadHref = document.createElement('a');
                downloadHref.setAttribute('class', 'mr');
                downloadHref.setAttribute('href', '/content/download?id=' + element.id);
                downloadHref.setAttribute('target', '_blank');

                var editHref = document.createElement('a');
                editHref.innerHTML = 'Edit';
                editHref.setAttribute('class', 'mr');
                editHref.setAttribute('href', '/bookEdition?id=' + element.id);

                var deleteHref = document.createElement('a');
                deleteHref.innerHTML = 'Delete';
                deleteHref.setAttribute('class', 'delete-button');
                deleteHref.setAttribute('onclick', 'deleteBook(' + element.id + ')');

                var printed = document.createElement('p');
                $.ajax({
                    url: '/publisherName/' + element.publisher_id,
                    success: function (data) {
                        printed.innerHTML = 'Publisher:' + data;
                    }
                });

                var year = document.createElement('p');
                year.innerHTML = 'Publishing year: ' + element.publish_year;

                var isbn = document.createElement('p');
                isbn.innerHTML = 'ISBN code: ' + element.isbn;

                var pages = document.createElement('p');
                pages.innerHTML = 'Amount of pages: ' + element.pageCount;

                var readP = document.createElement('p');
                readP.innerHTML = 'Read';

                var downloadP = document.createElement('p');
                downloadP.innerHTML = 'Download';

                var author = document.createElement('span');
                $.ajax({
                    url: '/authorName/' + element.author_id,
                    success: function (data) {
                        author.innerHTML = data;
                    }
                });

                titleHref.appendChild(titleP);

                info.appendChild(titleHref);
                info.appendChild(author);
                info.appendChild(pages);
                info.appendChild(printed);
                info.appendChild(year);
                info.appendChild(isbn);

                downloadHref.appendChild(downloadP);
                readHref.appendChild(readP);

                child.appendChild(img);
                child.appendChild(info);
                child.appendChild(clear);
                child.appendChild(downloadHref);
                child.appendChild(readHref);
                child.appendChild(editHref);
                child.appendChild(deleteHref);


                parent.appendChild(child);
            });

            var clear = document.createElement('div');
            clear.setAttribute('class', 'clear');
            parent.appendChild(clear);

        }
    });
}
