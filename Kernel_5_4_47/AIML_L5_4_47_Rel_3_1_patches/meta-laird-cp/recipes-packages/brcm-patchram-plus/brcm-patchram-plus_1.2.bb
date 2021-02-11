SUMMARY = "Broadcom Patchram Plus utility"
SECTION = "Wireless"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=691691b063f1b4034300dc452e36b68d"

inherit pkgconfig lrd-url

SRC_URI = "git://github.com/LairdCP/brcm_patchram.git;protocol=https"

SRCREV = "241e4896e2f2ee77883bdd6f1e404bf9e9df52f7"

S = "${WORKDIR}/git"

DEPENDS += "${@bb.utils.contains('DISTRO_FEATURES','bluez5','bluez5','',d)}"
RDEPENDS_${PN} = "bluez5"

RRECOMMENDS_${PN} = "lwb-backports-laird"
LDFLAGS= "-L${COMPONENTS_DIR}/aarch64/bluez5/usr/lib/"
EXTRA_OEMAKE = "LDFLAGS=${LDFLAGS}"

do_compile () {
	oe_runmake brcm_patchram_plus
}

do_install () {
	install -d ${D}${sbindir}
	install -m 755 brcm_patchram_plus ${D}${sbindir}
}
