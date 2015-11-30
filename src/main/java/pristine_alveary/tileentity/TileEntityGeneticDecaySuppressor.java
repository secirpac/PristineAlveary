package pristine_alveary.tileentity;

import pristine_alveary.modifier.GeneticDecaySuppressorModifier;
import forestry.api.apiculture.IAlvearyComponent;
import forestry.api.apiculture.IBeeModifier;

/**
 * PristineAlveary mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class TileEntityGeneticDecaySuppressor extends TileEntityBaseAlveary {

    private final IBeeModifier modifier = new GeneticDecaySuppressorModifier();

    public TileEntityGeneticDecaySuppressor() {
        super();
    }

    @Override
    public void initialize() {
        if (getCentralTE() != null) {
            ((IAlvearyComponent) getCentralTE()).registerBeeModifier(modifier);
        }
    }

    @Override
    protected void updateServerSide() {
        super.updateServerSide();
        if (!updateOnInterval(200)) {
            return;
        }

        if (!hasMaster() || !isIntegratedIntoStructure()) {
            return;
        }

        ((IAlvearyComponent) getCentralTE()).registerBeeModifier(modifier);
    }
}