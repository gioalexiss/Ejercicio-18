$(document).ready(function () {
    $('#search').on('input', function () {
        const query = $(this).val();
        if (query.length >= 1) {
            <!--AJAX-->
            $.ajax({
                url: "/api/search/suggestions",
                method: "GET",
                data: { query: query },
                success: function (result) {
                    const box = $('#suggestions-box');
                    box.empty();
                    if (result.length === 0) {
                        box.addClass('hidden');
                        return;
                    }
                    result.forEach(function (item) {
                        box.append('<div class="suggestion-item">' +
                            '<strong>' + item.nombre + '</strong><br>' +
                            '<small>' + item.descripcion + '</small>' +
                            '</div>');
                    });
                    box.removeClass('hidden');
                },
                error: function () {
                    console.error("Error al obtener sugerencias");
                }
            });
        } else {
            $('#suggestions-box').addClass('hidden').empty();
        }
    });
    $(document).click(function (e) {
        if (!$(e.target).closest('.search-container').length) {
            $('#suggestions-box').addClass('hidden').empty();
        }
    });
});