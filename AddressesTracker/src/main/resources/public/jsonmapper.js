$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/api/people/count"
    }).then(function(data) {
       $('.count').append(data);
    });
});