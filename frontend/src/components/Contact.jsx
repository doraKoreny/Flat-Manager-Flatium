import React, {Component} from 'react';
import {Collapsible, CollapsibleItem} from "react-materialize";

class Contact extends Component {
    render() {
        return (
            <div>
                <Collapsible>
                    <CollapsibleItem header='Landlord' icon='assignment_ind'>
                        <p>LandLord Michael</p>
                        <p>+36204891238</p>
                        <p>michael.landlord@gmail.com</p>
                    </CollapsibleItem>
                    <CollapsibleItem header='Janitor' icon='build'>
                        <p>Janitor James</p>
                        <p>+36308753921</p>
                        <p>james.the.janitor@gmail.com</p>
                    </CollapsibleItem>
                    <CollapsibleItem header='Doctor' icon='favorite'>
                        <p>Doctor Dóra</p>
                        <p>+367098327163</p>
                        <p>doctor.dora@gmail.com</p>
                    </CollapsibleItem>
                    <CollapsibleItem header='Notary' icon='feedback'>
                        <p>Notary Nicol</p>
                        <p>+36307638291</p>
                        <p>nicol.notary@gmail.com</p>
                    </CollapsibleItem>
                </Collapsible>
            </div>
        );
    }
}

export default Contact;