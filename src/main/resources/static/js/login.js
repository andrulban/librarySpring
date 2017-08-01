/**
 * Created by andrusha on 31.07.17.
 */
// csrf_token();
//
//
// function csrf_token() {
//     alert('1');
//     $(function () {
//         alert('2');
//         var token = $("meta[name='_csrf']").attr("content");
//         var header = $("meta[name='_csrf_header']").attr("content");
//         $(document).ajaxSend(function (e, xhr, options) {
//             xhr.setRequestHeader(header, token);
//         });
//     });
// }

// $(function () {
//         alert('2');
//         var token = $("meta[name='_csrf']").attr("content");
//         var header = $("meta[name='_csrf_header']").attr("content");
//         $(document).ajaxSend(function (e, xhr, options) {
//             xhr.setRequestHeader(header, token);
//         });}