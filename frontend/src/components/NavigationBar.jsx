import React, {Component} from 'react';
import {Navbar,NavItem,Icon,Modal} from 'react-materialize'
import Community from "./Community";
import Contact from "./Contact";

class NavigationBar extends Component {
    render() {
        return (
            <div>
                <Navbar brand='Flat Manager' className="deep-orange darken-2" right>
                    <NavItem>
                        <Modal
                            header='Community'
                            trigger={<NavItem><Icon left>accessibility</Icon>Community</NavItem>}>
                            <Community/>
                        </Modal>
                    </NavItem>
                    <NavItem>
                    <Modal
                        header='Modal Header'
                        trigger={<NavItem><Icon left>info</Icon>Contact</NavItem>}>
                        <Contact/>
                    </Modal>
                    </NavItem>
                    <NavItem>
                    <Modal
                        header='Modal Header'
                        trigger={<NavItem><Icon left>playlist_add_check</Icon>Bills</NavItem>}>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum</p>
                    </Modal>
                    </NavItem>
                    <NavItem>
                    <Modal
                        header='Modal Header'
                        trigger={<NavItem><Icon left>chat</Icon>Chat</NavItem>}>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum</p>
                    </Modal>
                    </NavItem>

                </Navbar>
            </div>
        );
    }
}

export default NavigationBar;