import React from "react";
import {PayPalButton} from 'react-paypal-button';

const payPalButtonComponent = () => {

    const success = (payment) => {
        console.log("Your payment was successful.");

    };
    const cancel = (data) => {
        console.log("Your payment was canceled.");

    };
    const error = (err) => {
        console.err("There was an error with your payment.");

    };
    return (
        <PayPalButton
        
        />
    );
};

export default payPalButtonComponent;