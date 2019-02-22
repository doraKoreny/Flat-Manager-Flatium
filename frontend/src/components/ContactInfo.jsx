import React, {Component} from 'react';

class ContactInfo extends Component {
    render() {
        return (
            <div>
                <div className="header"><h1>Contacts</h1></div>
                <div className="container">
                    <div className="row contactsheader">
                        <div className="col-2"><h4>Name</h4></div>
                        <div className="col-5"><h4>Phone</h4></div>
                        <div className="col-5"><h4>Email</h4></div>
                    </div>
                    <div className="row contact">
                        <div className="col-2">LandLord Michael</div>
                        <div className="col-5">+36204891238</div>
                        <div className="col-5">michael.landlord@gmail.com</div>
                    </div>
                    <div className="row contact">
                        <div className="col-2">Janitor James</div>
                        <div className="col-5">+36308753921</div>
                        <div className="col-5">james.the.janitor@gmail.com</div>
                    </div>
                    <div className="row contact">
                        <div className="col-2">Doctor Dóra</div>
                        <div className="col-5">+367098327163</div>
                        <div className="col-5">doctor.dora@gmail.com</div>
                    </div>
                    <div className="row lastcontact">
                        <div className="col-2">Notary Nicol</div>
                        <div className="col-5">+36307638291</div>
                        <div className="col-5">nicol.notary@gmail.com</div>
                    </div>
                </div>
            </div>
        );
    }
}

export default ContactInfo;
