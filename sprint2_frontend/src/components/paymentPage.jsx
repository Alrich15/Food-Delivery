import React, { Component } from 'react';
import { Link } from 'react-router-dom';

const PaymentPage = (props) => {
    return ( 
        <div class="mt-5">
            <div class="row">
                <div class="container-fluid d-flex justify-content-center">
                    <div class="col-sm-8 col-md-6">
                        <div class="card">
                            <div class="card-header">
                                <div class="row">
                                    <div class="col-md-6"> <span>CREDIT/DEBIT CARD PAYMENT</span> </div>
                                    <div class="col-md-6 text-right" style={{margintop: "-5px;"}}>
                                        <img src="https://img.icons8.com/color/36/000000/visa.png" />
                                        <img src="https://img.icons8.com/color/36/000000/mastercard.png" />
                                        <img src="https://img.icons8.com/color/36/000000/amex.png" />
                                    </div>
                                </div>
                                <div class="card-body" style={{height: "350px"}}>
                                    <div class="form-group">
                                        <label for="cc-number" class="control-label">CARD NUMBER</label> 
                                        <input id="cc-number" type="tel" class="input-lg form-control cc-number" autocomplete="cc-number" placeholder="•••• •••• •••• ••••" required />
                                    </div><br />
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="cc-exp" class="control-label">CARD EXPIRY</label>
                                                <input id="cc-exp" type="tel" class="input-lg form-control cc-exp" autocomplete="cc-exp" placeholder="•• / ••" required />
                                            </div><br />
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="cc-cvc" class="control-label">CARD CVC</label>
                                                <input id="cc-cvc" type="tel" class="input-lg form-control cc-cvc" autocomplete="off" placeholder="•••" required /> 
                                            </div><br />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="numeric" class="control-label" style={{textAlign : "justify"}} >CARD HOLDER NAME</label> 
                                        <input type="text" class="input-lg form-control"/>
                                    </div><br />
                                    <div class="form-group">
                                        <Link to="/bill/display">
                                            <input value="MAKE PAYMENT" type="button" class="btn btn-success btn-lg form-control" style={{fontSize: "8rem;"}} />
                                        </Link>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>  
                </div>
            </div>
     );
}
 
export default PaymentPage;