function changeProject() {
    //var projectID = document.getElementById('project_id').value;

    // var option = $(this).find(':selected');
    //
    var element = document.getElementById('project_id');
    var province_id = element.options[ element.selectedIndex ].getAttribute('data-province');
    var district_id = element.options[ element.selectedIndex ].getAttribute('data-district');
    var ward_id = element.options[ element.selectedIndex ].getAttribute('data-ward');
    var street_id = element.options[ element.selectedIndex ].getAttribute('data-street')


    // var cate1 = element.options[ element.selectedIndex ].getAttribute('data-cate1');
    // var cate2 = element.options[ element.selectedIndex ].getAttribute('data-cate2');
    // //alert(cate1);
    // document.getElementById("type_id").value = cate1;
    // document.getElementById("cate_id_2").value = cate2;
    //$("#sl_price_unit option").remove();
    // $.ajax({
    //     url: '/loadUnitPrice/' + cate1,
    //     success: function (data) {
    //         $('#sl_price_unit').append(data);
    //     }
    // });


    //console.log(element.options[ element.selectedIndex ].getAttribute('data-province'))

    $("#province_id option").remove();
    $("#district_id option").remove();
    $("#ward_id option").remove();
    $("#street_id option").remove();

    $.ajax({
        url: '/loadProvince/' + province_id,
        success: function (data) {
            $('#province_id').append(data);
            $.ajax({
                url: '/loadDistrictById/' + province_id+'/'+district_id,
                success: function (data) {
                    //console.log(data);
                    $('#district_id').append(data);
                    $.ajax({
                        url: '/loadWardById/' + district_id+'/'+ward_id,
                        success: function (data1) {
                            $('#ward_id').append(data1);

                            $.ajax({
                                url: '/loadStreetById/' + province_id +'/'+ district_id+'/'+street_id,
                                success: function (data1) {
                                    $('#street_id').append(data1);
                                }
                            });

                        }
                    });
                }
            });
        }
    });

    setTimeout(function () {
        generate_location();
    }, 2000);
}


function change(value) {

    var proID = document.getElementById('province_id').value;
    $("#district_id option").remove();
    $("#ward_id option").remove();
    $("#street_id option").remove();
    $.ajax({
        url: '/loadDistrict/' + proID,
        success: function (data) {
            //console.log(data);
            $('#district_id').append(data);
            var disID = document.getElementById('district_id').value;
            $.ajax({
                url: '/loadWard/' + disID,
                success: function (data1) {
                    $('#ward_id').append(data1);
                }
            });
        }
    });
    
    setTimeout(function () {
        generate_location();
    }, 2000);

}

function change_dis(value) {
    $("#ward_id option").remove();
    $("#street_id option").remove();
    var proID = document.getElementById('province_id').value;
    var disID = document.getElementById('district_id').value;

    $.ajax({
        url: '/loadWard/' + disID,
        success: function (data1) {
            $('#ward_id').append(data1);
        }
    });

    $.ajax({
        url: '/loadStreet/' + proID +'/'+ disID,
        success: function (data1) {
            $('#street_id').append(data1);
        }
    });
    setTimeout(function () {
        generate_location();
    }, 3000);
}

function change_ward(value) {
    setTimeout(function () {
        generate_location();
    }, 2000);
}



function change_street(value) {
    setTimeout(function () {
        generate_location();
    }, 2000);
}

function generate_location() {
    var str = '';
    str += $('#street_id').find(":selected").text()+', ';
    str += $('#ward_id').find(":selected").text()+', ';
    str += $('#district_id').find(":selected").text()+', ';
    str += $('#province_id').find(":selected").text();

    $('#address').val(str);
}