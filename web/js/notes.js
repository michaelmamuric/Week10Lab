$(document).ready(function() {    
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
                $("body").html("<div>Failure</div>");
            }
        });
        event.preventDefault();
    });
});
