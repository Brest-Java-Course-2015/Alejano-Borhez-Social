var url = "gallery/cloudAPI";

$.ajax({
    type: 'GET',
    url: url,
    success: function (data, textStatus, jqXHR) {
                                 $.cloudinary.config(data);

                               },
    error: function(jqXHR, textStatus, errorThrown) {
                       console.log(jqXHR, textStatus, errorThrown);
                       alert('restAPI: ' + textStatus);
                   }

});