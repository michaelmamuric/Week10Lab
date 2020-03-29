$(document).ready(function() {
    // Add Note
    $("#addNote").submit(function(event) {          
        $.ajax({
            type: "post",
            url:  $(this).attr("action"),
            data: $(this).serialize(),
            success: function(response) {
                $("body").html(response);
                $("#result").html("New note added.");
            },
            error: function() {
                $("body").html("An error has occured.");
            }
        });
        event.preventDefault();
    });
});

$(document).ready(function() {
    // Before Edit
    $(".beforeEdit").submit(function(event) {
        $.ajax({
            type: "post",
            url: $(this).attr("action"),
            data: $(this).serialize(),
            success: function(response) {
                $("body").html(response);
            },
            error: function() {
                $("body").html("An error has occured.");
            }
        });
        event.preventDefault();
    });
});
