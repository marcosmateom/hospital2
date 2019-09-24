$(document).ready(
        function() {
            $.ajax({
                type: 'GET',
                url: 'http://localhost:8080/proyectoDB2-Hospital1/getServicios',
                dataType: 'json',
                success: function(data) {
                    var $pData = $('#serviciosData');
                    $pData.empty();
                    for (var i = 0; i < data.length; i++) {
                        $pData.append("<option value="+data[i].subCatId+">"+data[i].subCat+"</option>");
                    }
                    if(data.length==0){
                        $pData.append("<p>No hay datos disponibles</p>");
                    }
                },
                error : function() {
                    var $pData = $('#patientData');
                    $pData.empty();
                    $pData.append("<p>No hay datos disponibles</p>");
                }
            });
});
