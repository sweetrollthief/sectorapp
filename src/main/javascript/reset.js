import $ from "jquery";
import React from 'react';
import ReactDOM from 'react-dom';
import SectorForm from './component/sector-form.jsx';

function doRequest(uri, requestData) {
    return Promise.resolve($.ajax({
        url: uri,
        method: 'POST',
        dataType : 'json',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(requestData)
    }));
};

const validate = (data) => {
    if (!data.isAgreed) throw "Must agree to terms";
    if (data.name.length < 3) throw "The Name must contain at least three characters";
    return {
        name: data.name,
        sectors: data.sectors,
        isAgreed: data.isAgreed
    };
};

const doGetSectors = () => doRequest('/sector/list', {});
const doGetState = () => doRequest('/user/get', {});
const doSubmitForm = (data) => doRequest('/user/save', validate(data));

$(document).ready(function() {
    doGetSectors()
        .then(
            x => ReactDOM.render(<SectorForm id="form" sectors={ x } onInit={ doGetState } onSubmit={ doSubmitForm }/>, document.querySelector('#app')),
            e => alert(JSON.stringify(e))
        );
});