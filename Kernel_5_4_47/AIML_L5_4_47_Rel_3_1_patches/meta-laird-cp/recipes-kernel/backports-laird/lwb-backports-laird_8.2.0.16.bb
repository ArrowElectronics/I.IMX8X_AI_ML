SUMMARY = "Laird Connectivity Wi-Fi Backports for LWB"

BACKPORTS_CONFIG = "defconfig-lwb"

SRC_URI += "${LRD_LWB_URI_BASE}/${BACKPORTS_FILE}"
SRC_URI += "file://0001-brcmfmac-Use-request_firmware_direct-for-the-clm_blo.patch"

SRC_URI += "file://debug.cfg"
SRC_URI[md5sum] = "a764a3171d00ce3b829545aa34c43cbc"
SRC_URI[sha256sum] = "aa0fd00c6b5d899436b3b2665f1110ead4417a1bde71632480c934ca8e5b2bea"

RREPLACES_${PN} = "summit-backports-laird"
RCONFLICTS_${PN} = "summit-backports-laird sterling-backports-laird"

include backports-laird.inc
