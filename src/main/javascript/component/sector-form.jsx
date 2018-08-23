import $ from "jquery";
import React from 'react';
import PropTypes from 'prop-types';
import { withStyles } from '@material-ui/core/styles';
import Paper from '@material-ui/core/Paper';
import Typography from '@material-ui/core/Typography';
import FormControl from '@material-ui/core/FormControl';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import Input from '@material-ui/core/Input';
import InputLabel from '@material-ui/core/InputLabel';
import Checkbox from '@material-ui/core/Checkbox';
import Button from '@material-ui/core/Button';

import SectorList from './sector-list.jsx';
import ErrorBar from './errorbar.jsx';

const styles = theme => ({
    containerCentered: {
        margin: 0,
        position: 'absolute',
        top: '50%',
        left: '50%',
        transform: 'translate(-50%, -50%)',
    },
    form: {
        padding: 25,
    },
    formEntry: {
        margin: '25px 0',
    },
    input: {
        width: '100%',
    },
    button: {
        textAlign: 'right',
    }
});

const drillDown = (acc, root) => {
    acc.push(root.id);
    const children = root.children;
    if (root.children) children.forEach(x => drillDown(acc, x));
    return acc;
};

const drillUp = (acc, sectors, searchId) => {
    for (var i = 0; i < sectors.length; i++) {
        const sector = sectors[i];
        if (sector.id == searchId) {
            acc.push(sector.id);
            return true;
        }
        const children = sector.children;
        if (children) {
            const result = drillUp(acc, children, searchId);
            if (result) {
                acc.push(sector.id);
                return true;
            }
        }
    }

    return false;
};

const findSector = (sectors, searchId) => {
    for (var i = 0; i < sectors.length; i++) {
        const sector = sectors[i];
        if (sector.id == searchId) return sector;
        const children = sector.children;
        if (children) {
            const searchResult = findSector(children, searchId);
            if (searchResult) return searchResult;
        }
    }

    return null;
}

class SectorForm extends React.Component {
    state = {
        data: {
            name: '',
            sectors: [],
            isAgreed: false
        },
        error: {
            trigger: false,
            message: ""
        }
    };

    handleRequest = (doRequest, callback) => {
        try {
            doRequest()
                .then(
                    x => callback(x),
                    e => this.showMessage(JSON.stringify(e))
                )
                .catch(
                    e => this.showMessage(e)
                );
        } catch (e) {
            this.showMessage(e)
        };
    }

    componentDidMount = () => {
        const doRequest = () => this.props.onInit();
        const callback = x => this.setState({ data: x });
        this.handleRequest(doRequest, callback);
    };

    toggleAgree = event => {
        const data = this.state.data;
        data.isAgreed = event.target.checked;
        this.setState({ data });
    };

    handleNameChange = event => {
        const data = this.state.data;
        data.name = event.target.value;
        this.setState({ data });
    };

    toggleSector = id => () => {
        const sector = findSector(this.props.sectors, id);
        const checkedValues = this.state.data.sectors;
        const value = checkedValues.indexOf(id) === -1;
        const toggledValues = drillDown([], sector);

        if (value) {
            toggledValues.filter(x => checkedValues.indexOf(x) === -1).forEach(x => checkedValues.push(x));
            this.setState({ checkedValues });
        } else {
            drillUp(toggledValues, this.props.sectors, id);
            const newCheckedValues = checkedValues.filter(x => toggledValues.indexOf(x) === -1);
            const data = this.state.data;
            data.sectors = newCheckedValues;
            this.setState({ data });
        }
    }

    submitForm = () => {
         const doRequest = () => this.props.onSubmit(this.state.data);
         const callback = x => this.showMessage("Saved");
         this.handleRequest(doRequest, callback);
    };

    showMessage = (message) => {
        this.setState({ error: {
            trigger: true,
            message: message
        }});
    };

    hideError = () => {
        this.setState({ error: { trigger: false } });
    };

    render() {
        const { classes, sectors } = this.props;
        return (
            <div>
                <div className={classes.containerCentered}>
                    <Paper className={classes.form} elevation={1}>
                        <Typography className={ classes.formEntry } color="textSecondary">
                            Please enter your name and pick the Sectors you are currently involved in
                        </Typography>
                        <FormControl className={ classes.formEntry, classes.input }>
                            <InputLabel htmlFor="userName">Name</InputLabel>
                            <Input id="userName" onChange={this.handleNameChange} value={ this.state.data.name } />
                        </FormControl>
                        <SectorList className={ classes.formEntry } sectors={ sectors } checked={ this.state.data.sectors } onChange={ this.toggleSector } />
                        <div className={ classes.formEntry }>
                            <FormControlLabel
                                control={
                                    <Checkbox
                                        checked={ this.state.data.isAgreed }
                                        onChange={ this.toggleAgree }
                                        value="isAgreed"
                                        color="primary"
                                    />
                                }
                                label="Agree to terms"
                            />
                        </div>
                        <div className={ classes.formEntry, classes.button } >
                            <Button variant="contained" color="primary" onClick={ this.submitForm }>Save</Button>
                        </div>
                    </Paper>
                </div>
                <ErrorBar open={ this.state.error.trigger } message={ this.state.error.message } onClose={ this.hideError }/>
            </div>
        );
    }
}

SectorForm.propTypes = {
  classes: PropTypes.object.isRequired,
};

export default withStyles(styles)(SectorForm);