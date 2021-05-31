/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

"use strict";

let module = angular.module('CustomerCreator', ['ngResource']);

module.factory('customerCreatorJetty', function ($resource) {
    return $resource('http://localhost:9000/customercreateaccount', null, {update: {method: 'POST'}});
});

module.controller('CustomerController', function (customerCreatorJetty) {
    this.createAccount = function (customer) {
        customerCreatorJetty.save({}, customer, function() {
            window.location.reload();
        });
    };
});