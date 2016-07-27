
setTimeout ( function() {
                var url = $.cookie("Referer");
                if (url != null) {
                window.location = $.cookie("Referer");
                } else {
                window.location = "user";
                };

    }, 10000);