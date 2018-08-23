import $ from "jquery";
import React from 'react';
import PropTypes from 'prop-types';
import { withStyles } from '@material-ui/core/styles';
import Typography from '@material-ui/core/Typography';
import List from '@material-ui/core/List';
import ListSubheader from '@material-ui/core/ListSubheader';
import ListItem from '@material-ui/core/ListItem';
import ListItemText from '@material-ui/core/ListItemText';
import Checkbox from '@material-ui/core/Checkbox';
import Collapse from '@material-ui/core/Collapse';

const styles = theme => ({
    root: {
        width: '100%',
        backgroundColor: theme.palette.background.paper,
    },
    list: {
        paddingLeft: theme.spacing.unit * 4,
        overflow: 'auto',
        maxHeight: 400,
        paddingLeft: 0,
    },
});

class SectorList extends React.Component {
    renderChildren(sectors, offset) {
        const newOffset = offset + 25;
        return (
            <List component="div" disablePadding>
                { this.renderSectors(sectors, newOffset) }
            </List>
        );
    };

    renderSector(sector, offset) {
        const sectorId = sector.id;
        const sectorLabel = sector.label;
        const styleEntry = { paddingLeft: offset + 'px' };

        return (
            <ListItem
                key={ 'sector_' + sector }
                role={ undefined }
                dense
                button
                style={ styleEntry }
                onClick={ this.props.onChange(sectorId) }
            >
                <Checkbox
                    value={ sectorId }
                    checked={ this.props.checked.indexOf(sectorId) !== -1 }
                    tabIndex={-1}
                    disableRipple
                />
                <ListItemText primary={ sectorLabel } />
            </ListItem>
        );
    };

    renderSectors(sectors, offset) {
        return sectors.reduce((x, y) => {
            const children = y.children ? this.renderChildren(y.children, offset) : [];
            const listElement = this.renderSector(y, offset);
            x.push(listElement);
            x.push(children);
            return x;
        }, []);
    };

    render() {
        const { classes, sectors } = this.props;
        const sectorList = this.renderSectors(sectors, 0);

        return (
            <div className={ classes.root }>
                <Typography color="textSecondary">
                    Pick one or more selectors
                </Typography>
                <List className={ classes.list }>
                    { sectorList }
                </List>
            </div>
        )
    };
}

SectorList.propTypes = {
  classes: PropTypes.object.isRequired,
};

export default withStyles(styles)(SectorList);