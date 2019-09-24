$(document).ready(
        function() {
            
            $.ajax({
                type: 'GET',
                url: 'http://localhost:8080/proyectoDB2-Hospital1/SpecialTypeInfo',
                dataType: 'json',
                success: function(data) {
                    var $pData = $('#especialidadData');
                    $pData.empty();
                    for (var i = 0; i < data.length; i++) {
                        $pData.append("<option value="+data[i].idspecial+">"+data[i].especialidad+"</option>");
                    }
                    if(data.length==0){
                        $pData.append("<p>No hay datos disponibles</p>");
                    }
                },
                error : function() {
                    var $pData = $('#especialidadData');
                    $pData.empty();
                    $pData.append("<p>No hay datos disponibles</p>");
                }
            });
});











