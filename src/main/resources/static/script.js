(function(){
    $("#tabclientes").on("click",".js-delete", function(){
        let botaoClicado = $(this);
        $("#btnsim")
            .attr("data-id", botaoClicado.attr("data-id"));
        $("#modalcliente").modal("show");
    });

    $("#btnsim").on("click",function(){
        let botaoSim = $(this);
        let id = botaoSim.attr("data-id");
        $.ajax(
            {
                url: "/clientes/remover/" + id,
                method: "GET",
                success: function(){
                    window.location.href = "/clientes";
                }
            }
        );
    });
    
    $("#tabclinicas").on("click",".js-delete", function(){
        let botaoClicado = $(this);
        $("#btnsim")
            .attr("data-id", botaoClicado.attr("data-id"));
        $("#modalclinica").modal("show");
    });

    $("#btnsim").on("click",function(){
        let botaoSim = $(this);
        let id = botaoSim.attr("data-id");
        $.ajax(
            {
                url: "/clinicas/remover/" + id,
                method: "GET",
                success: function(){
                    window.location.href = "/clinicas";
                }
            }
        );
    });
    
      $("#tabagendamentos").on("click",".js-delete", function(){
        let botaoClicado = $(this);
        $("#btnsim")
            .attr("data-id", botaoClicado.attr("data-id"));
        $("#modalagendamento").modal("show");
    });

    $("#btnsim").on("click",function(){
        let botaoSim = $(this);
        let id = botaoSim.attr("data-id");
        $.ajax(
            {
                url: "/agendamentos/remover/" + id,
                method: "GET",
                success: function(){
                    window.location.href = "/agendamentos";
                }
            }
        );
    });

})();
