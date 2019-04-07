import React, {Component} from 'react';
import {Collapsible,CollapsibleItem} from 'react-materialize'

class Community extends Component {
    render() {
        return (
            <div>
                <Collapsible>
                    <CollapsibleItem header='Residental Meetup' icon='business_center'>
                        Residental Meetup will be at thursday.
                    </CollapsibleItem>
                    <CollapsibleItem header='Garbage collecting time' icon='delete'>
                        Next tuesday.
                    </CollapsibleItem>
                    <CollapsibleItem header='Common cost' icon='attach_money'>
                        5000 Forint
                    </CollapsibleItem>
                </Collapsible>
            </div>
        );
    }
}

export default Community;