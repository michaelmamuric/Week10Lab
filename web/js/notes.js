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
                $("#result").html("An error has occured.");
            }
        });
        event.preventDefault();
    });
    
    // Delete Note
    $("#deleteNote").submit(function(event) {
        $.ajax({
            type: "post",
            url: $(this).attr("action"),
            data: $(this).serialize(),
            success: function(response) {
                $("body").html(response);
            },
            error: function() {
                $("#result").html("Error in deleting note.");
            }
        });
        event.preventDefault();
    });
   
    // Edit Note
    $("#duringEdit").keyup(function() {
        $.ajax({
            type: "post",
            url: $(this).attr("action"),
            data: $(this).serialize(),
            success: function(response) {
                $("body").html(response);
            },
            error: function() {
                $("#result").html("Error in editing note.");
            }
        });
    });
});
    