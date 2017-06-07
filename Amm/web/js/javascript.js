/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function createElement(user){
    var link = $("<a>")
            .attr("href", "bacheca.html?b_id="+user.id)
            .html(user.nome+" "+user.cognome);
    return $("<li>")
            .append(link);
}

function stateSuccess(data){
    var userListPage = $("#usersList");
    
    $(userListPage).empty();
    for(var instance in data){
        $(userListPage).append(createElement(data[instance]));
    }
}

function stateFailure(data, state){
    console.log(state);
}

$(document).ready(function(){
    $("#searchUser").click(function(){
        
        var wantedNerd = $("#searchField")[0].value;
        
        $.ajax({
            url: "filter.json",
            data:{
                cmd: "search",
                q: wantedNerd
            },
            dataType:"json",
            success: function(data, state){
                stateSuccess(data)
            },
            error: function(data, state){
                stateFailure(data, state)
            }
        });
    })
});
