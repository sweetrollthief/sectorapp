import React from 'react';
import PropTypes from 'prop-types';
import { withStyles } from '@material-ui/core/styles';
import Button from '@material-ui/core/Button';
import Snackbar from '@material-ui/core/Snackbar';
import IconButton from '@material-ui/core/IconButton';
import CloseIcon from '@material-ui/icons/Close';

const styles = theme => ({
    close: {
        width: theme.spacing.unit * 4,
        height: theme.spacing.unit * 4,
    },
});

class ErrorBar extends React.Component {
    handleClose = () => {
        this.props.onClose();
    }

    render() {
        const { classes, open, message } = this.props;
        return (
            <Snackbar
                anchorOrigin={{
                    vertical: 'bottom',
                    horizontal: 'left',
                }}
                open={ open }
                autoHideDuration={ 4500 }
                onClose={ this.handleClose }
                ContentProps={{
                    'aria-describedby': 'message-id',
                }}
                message={<span id="message-id">{ message }</span>}
                action={[
                    <Button key="undo" color="secondary" size="small" onClick={ this.handleClose }>
                      UNDO
                    </Button>,
                    <IconButton
                      key="close"
                      aria-label="Close"
                      color="inherit"
                      className={ classes.close }
                      onClick={ this.handleClose }
                    >
                      <CloseIcon />
                    </IconButton>,
                ]}
            />
        );
    }
}

ErrorBar.propTypes = {
  classes: PropTypes.object.isRequired,
};

export default withStyles(styles)(ErrorBar);