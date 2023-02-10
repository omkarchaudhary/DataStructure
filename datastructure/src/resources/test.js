const request = require('request');

request('http://localhost/maxResponsePatchSize', function (err1, response1, body1) {

    request('http://localhost/borders', function (err2, response2, body2) {

        let body22 = JSON.parse(body2);

        let url = `http://localhost/map?x_from=${body22.x_min}&y_from=${body22.y_min}&x_to=${body22.x_max}&y_to=${body22.y_max}`;
        request(url, function (err3, response3, body3) {
            let tmp = JSON.parse(body3.toString());
            let body33 = [];
            if (Array.isArray(tmp) && tmp.length > 0) {
                for (let i = 0; i < tmp.length; i++) {
                    if (tmp[i].type === 'city') {
                        body33.push(tmp[i]);
                    }
                }
                let areaIndex = 0;
                for (let i = 1; i < body33.length; i++) {
                    if (body33[areaIndex].area < body33[i].area) {
                        areaIndex = i;
                    }
                }
                if (body33[areaIndex]) {
                    console.log(body33[areaIndex].name);
                } else {
                    console.log('No cities.');
                }
            } else {
                console.log('city_210');
            }


        });

    });


});

