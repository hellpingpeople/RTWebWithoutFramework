/**
 * Created by Alexander Vashurin on 1/26/17.
 */

// Rebuild city
$('#search').val(sessvars.search)
if(sessvars.page == undefined) {
    sessvars.page = 1
}
if(sessvars.size == undefined) {
    sessvars.size = 10
}
$('#size option[value='+sessvars.size+']').attr('selected', 'true')

// Search function
var search = function() {
    sessvars.search = $('#search').val()
    sessvars.size = $('#size').val()
    $('#result').load(({search: sessvars.search, size: sessvars.size, page: sessvars.page}),  function() {
        $('#content').css('visibility', 'visible')
    })
}

// Events handler
$('#submit').click(function() {
    sessvars.page = 1
    search()
})
$('#search').keyup(function() {
    sessvars.page = 1
    search()
})
$('#nextPage').live('click', function(e) {
    sessvars.page = $(this).attr('href')
    e.preventDefault()
    search()
})

// Init
if(sessvars.search != undefined) {
    $('#content').css('visibility', 'hidden')
    search()
}
